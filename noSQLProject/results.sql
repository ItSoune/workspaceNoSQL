SELECT e.empno
FROM EMP e, DEPT d
GROUP BY e.empno
ORDER BY 1, e.empno, 7;