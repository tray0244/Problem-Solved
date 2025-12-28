select count(*) as count
from ecoli_data a
where 1 = 1 and (genotype & 2) != 2 and ((genotype & 4) = 4 or (genotype & 1) = 1)