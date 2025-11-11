-- 코드를 입력하세요
SELECT
    I.ingredient_type,
    SUM(F.total_order) AS TOTAL_ORDER
FROM
    ICECREAM_INFO AS I
JOIN
    FIRST_HALF AS F ON I.FLAVOR = F.FLAVOR
GROUP BY
    I.ingredient_type
ORDER BY
    TOTAL_ORDER ASC;
