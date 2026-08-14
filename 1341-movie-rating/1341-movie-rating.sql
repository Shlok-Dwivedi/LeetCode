# Write your MySQL query statement below
SELECT name AS results
FROM Users
WHERE user_id=(
    SELECT mr.user_id
    FROM MovieRating mr
    JOIN Users u ON u.user_id=mr.user_id
    GROUP BY mr.user_id,u.name
    ORDER BY COUNT(*) DESC,u.name
    LIMIT 1
)
UNION ALL
SELECT title AS results
FROM Movies
WHERE movie_id=(
    SELECT mr.movie_id
    FROM MovieRating mr
    JOIN Movies m ON m.movie_id=mr.movie_id
    WHERE created_at>='2020-02-01' AND created_at<'2020-03-01'
    GROUP BY mr.movie_id,m.title
    ORDER BY AVG(rating) DESC,m.title
    LIMIT 1
);