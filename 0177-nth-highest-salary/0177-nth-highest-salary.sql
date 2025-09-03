CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    SELECT salary FROM (
      SELECT DISTINCT salary,
             DENSE_RANK() OVER (ORDER BY salary DESC) AS rk
      FROM Employee
    ) t
    WHERE t.rk = N
    LIMIT 1
  );
END