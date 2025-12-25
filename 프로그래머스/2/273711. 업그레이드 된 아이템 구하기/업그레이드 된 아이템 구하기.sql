select distinct i.item_id, i.item_name, i.rarity
from item_info i
join item_tree t on t.item_id = i.item_id
WHERE t.PARENT_ITEM_ID IN (SELECT ITEM_ID FROM ITEM_INFO WHERE RARITY = 'RARE')
order by i.item_id desc;

