-- 코드를 입력하세요
-- 재구매한 회원 ID, 재구매한 상품 ID
select user_id, product_id
from online_sale
group by user_id, product_id
having count(*) >= 2
order by 
    user_id asc,
    product_id desc;