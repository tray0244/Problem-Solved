-- 코드를 입력하세요
SELECT SUBSTRING(product_code, 1, 2) AS category,
       COUNT(*) AS products_count
FROM product
GROUP BY category
ORDER BY category;