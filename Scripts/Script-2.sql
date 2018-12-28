INSERT INTO proj_library.`day`
(daty)
VALUES(NOW());

select datediff(daty, now())
from day;
