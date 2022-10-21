SELECT channel
     , mem.member_id
     , mobile
     , age
     , gender
     , city
     , city_tier
     , order_create_time
     , pay_time
     , first_registered_time
     , purchase_channel_within_last_year_r12
     , lifecycle_status
     , member_tier
from (select member_id
      from hmcdm_cdp.mid_dwd_online_mem_order_pay_di
      where ds = '20221013'
        and order_create_time between '2022-10-13 08:00:00' and '2022-10-13 23:59:59'
        and article_id in (
                           1094185001, 1110838001, 1094190001, 1094188001, 1094191001, 1104619001, 1095079001,
                           1095080001, 1124046001, 1104747001, 1104745001, 1104742001, 1104746001, 1104621001,
                           1104630001, 1109623001, 1104763001, 1104633001, 1104624001, 1104746002, 1104775001,
                           1110876001, 1104779001, 1112402001, 1104765001, 1104767001, 1104743001, 1104748001,
                           1133794001, 1113852001, 1108819001, 1104773001, 1130323001, 1095078001, 1099039001,
                           1095077001, 1110884001, 1099032001
          )
      group by member_id) orderT
         join (select * from hmads_cdp_marketing.profile_member_all where ds = '20221013') as mem
              on orderT.member_id = mem.member_id
where xx in (
             101810174059964, 101850221642380, 101850226703344, 101810143303126, 101850213320908, 101810159216830,
             101850237970578, 101852001128253, 101810159903413, 101810161058488, 101810141828889, 101851912303007,
             101851911152581, 101810146543868, 101811255946939, 101810142733791, 101810147135435, 101810159611071,
             101810615243941, 101810163387472, 101811057926519, 101850241357226, 101810145762536, 101850224918737,
             101850228720113, 101810146588384, 101810153642662, 101810154007237, 101810158786226, 101850260394684,
             101810206197882
    )



with memberInfo as (
    select * from(
                         (select member_id,channel,order_create_time,created_at as pay_time
                          from hmcdm_cdp.mid_dwd_online_mem_order_pay_di
                          where ds = '20221013'
                            and order_create_time between '2022-10-13 08:00:00' and '2022-10-13 23:59:59'
                            and article_id in (
                                               1094185001, 1110838001, 1094190001, 1094188001, 1094191001, 1104619001, 1095079001,
                                               1095080001, 1124046001, 1104747001, 1104745001, 1104742001, 1104746001, 1104621001,
                                               1104630001, 1109623001, 1104763001, 1104633001, 1104624001, 1104746002, 1104775001,
                                               1110876001, 1104779001, 1112402001, 1104765001, 1104767001, 1104743001, 1104748001,
                                               1133794001, 1113852001, 1108819001, 1104773001, 1130323001, 1095078001, 1099039001,
                                               1095077001, 1110884001, 1099032001
                              )
                          group by member_id,channel,order_create_time,created_at) orderT
                             join (select * from hmads_cdp_marketing.profile_member_all where ds = '20221013') as mem
                         on orderT.member_id = mem.member_id)
                         lateral view explode(split(purchase_time ,','))  as purchase_time_all
                 )

select months,
       member_tier,
       count(1) as times
from (select case
                 when purchase_time_all <= '2022-10-13'
                     and purchase_time_all > add_months('2022-10-13', -1) then 1
                 when purchase_time_all <= add_months('2022-10-13', -1)
                     and purchase_time_all > add_months('2022-10-13', -3) then 3
                 when purchase_time_all <= add_months('2022-10-13', -3)
                     and purchase_time_all > add_months('2022-10-13', -6) then 6
                 when purchase_time_all <= add_months('2022-10-13', -6)
                     and purchase_time_all > add_months('2022-10-13', -12) then 12
    end as months
           , member_tier
      from memberInfo)
group by months, member_tier



with memberInfo as (
    select mem.* from(
    (select member_id,channel,order_create_time,created_at as pay_time
    from hmcdm_cdp.mid_dwd_online_mem_order_pay_di
    where ds between '20221013' and '20221019'
    and order_create_time between '2022-10-13 08:00:00' and '2022-10-19 23:59:59'
    group by member_id,channel,order_create_time,created_at) orderT
    join (select * from hmads_cdp_marketing.profile_member_all where ds = '20221019') as mem
    on orderT.member_id = mem.member_id))

select
    avg(atv_r12) as avg_atv
     ,avg(freq_in_days_r12_payment) as avg_freq
     ,member_tier
from memberInfo
group by member_tier ;