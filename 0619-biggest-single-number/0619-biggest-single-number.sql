# Write your MySQL query statement below
SELECT (
  SELECT num
  FROM mynumbers
  GROUP BY num
  HAVING COUNT(num) = 1
  ORDER BY num DESC
  LIMIT 1
) AS num;