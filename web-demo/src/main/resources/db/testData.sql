-- wd_user
insert into wd_user values('robin','robin');
insert into wd_user values('sean','sean');
insert into wd_user values('roy','roy');

commit;

-- wd_sort
insert into wd_sort values (1, 'IBM');
insert into wd_sort values (2, 'SONY');
insert into wd_sort values (3, 'HP');

commit;

-- wd_product
insert into wd_product
values
  (1,
   1,
   'IBM-T43',
   14500,
   13500,
   'CPU Processor:Intel Pentium-M(Dothan 760)2.0GHz',
   'Chipset: Intel 915PM System GHz: 533 MHz Second Level Cache:2M Graphic Display Card,Internal Bluetooth',
   to_date('2013-10-22', 'yyyy-mm-dd'),
   100,
   'images/IBMT43CH8.jpg');

insert into wd_product
values
  (2,
   3,
   'HP-NC4200',
   13500,
   13000,
   'CPU Processor:Intel Pentium-M(Dothan 760)2.0GHz',
   'Chipset: Intel 915PM System GHz: 533 MHz Second Level Cache:2M Graphic Display Card,Internal Bluetooth',
   to_date('2013-10-22', 'yyyy-mm-dd'),
   100,
   'images/HPNC4200.jpg');

insert into wd_product
values
  (3,
   2,
   'SONY-A21C',
   16500,
   15000,
   'CPU Processor:Intel Pentium-M(Dothan 760)2.0GHz',
   'Chipset: Intel 915PM System GHz: 533 MHz Second Level Cache:2M Graphic Display Card:ATI Mobility Radeon X300',
   to_date('2013-10-22', 'yyyy-mm-dd'),
   100,
   'images/SONYA21C.jpg');

select * from wd_product;

commit;

