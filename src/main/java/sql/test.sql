select o.ord_no, o.ord_dtm, op.prd_no, op.prd_no, op.qty
from tb_order o, tb_order_product op
where o.ord_no = op.ord_no



select m.mem_id,o.ord_no, o.ord_dtm, op.prd_no, op.qty
from tb_mem m, tb_order o, tb_order_product op
where o.ord_no = op.ord_no and m.mem_id = o.mem_id


select op.prd_no, op.qty, m.*
from tb_order_product op, 
(select m.mem_id,o.ord_no, o.ord_dtm
from tb_mem m, tb_order o
where m.mem_id = o.mem_id) m
where op.ord_no = m.ord_no