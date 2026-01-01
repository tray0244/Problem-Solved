with recursive gen as (
    select
        id,
        parent_id,
        1 as generation
    from ecoli_data
    where parent_id is null

    union all

    select
        c.id,
        c.parent_id,
        g.generation + 1
    from ecoli_data c
    join gen g
      on c.parent_id = g.id
),
leaf as (
    select g.id, g.generation
    from gen g
    left join ecoli_data e
      on g.id = e.parent_id
    where e.parent_id is null
)
select
    count(*) as count,
    generation
from leaf
group by generation
order by generation;