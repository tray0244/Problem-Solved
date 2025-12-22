select DATE_FORMAT(n.sales_date, '%Y-%m-%d') as sales_date, n.product_id, n.user_id, n.sales_amount
from offline_sale as f
join online_sale as n on n.product_id = f.product_id
where n.sales_date >= '2022-03-01' and n.sales_date < '2022-04-01';
order by slaes_date asc