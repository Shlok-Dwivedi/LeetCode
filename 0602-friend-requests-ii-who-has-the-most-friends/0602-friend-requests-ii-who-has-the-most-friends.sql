# Write your MySQL query statement below
SELECT
  id,
  COUNT(*) AS num
FROM
  (
    -- Combine all IDs from both columns into a single list
    SELECT requester_id AS id FROM RequestAccepted
    UNION all
    SELECT accepter_id AS id FROM RequestAccepted
  ) AS AllFriendIDs
GROUP BY
  id
ORDER BY
  num DESC
LIMIT 1;