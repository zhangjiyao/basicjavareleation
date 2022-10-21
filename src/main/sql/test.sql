
select *
from (
         (select *
          from hmcdm_cdp.mid_dwd_online_mem_order_pay_di
          where ds between '20221012' and '20221013'
            and order_create_time between '2022-10-12 12:00:00' and '2022-10-13 07:59:59') as orderT
             join (select member_id
                   from hmads_cdp_marketing.profile_member_all
                   where ds = '20221013' and member_tier = 'Plus') as mem
         on orderT.member_id = mem.member_id
         )
