﻿--Điểm cao nhất của mỗi đề
SELECT MAX(SCORE.SCORE) AS MAXDIEM  FROM  SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'Lập Trinh Mạng'

--Điểm Trung Bình của mỗi đề
SELECT AVG(SCORE.SCORE) AS AVGDIEM  FROM  SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'Lập Trinh Mạng'

--Mỗi đề có bao nhiêu tài khoản từng làm
SELECT  SCORE.CHUDE_ID,COUNT(DISTINCT SCORE.TAIKHOAN_ID) AS COUNT FROM SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'Lập Trinh Mạng' GROUP BY SCORE.CHUDE_ID  ;

--Mỗi đề đã được làm bào nhiêu lần 
SELECT  SCORE.CHUDE_ID,COUNT(SCORE.TAIKHOAN_ID) AS COUNT FROM SCORE JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID WHERE CHUDE.TENCHUDE = N'Lập Trinh Mạng' GROUP BY SCORE.CHUDE_ID  ;

--DIEM CAO NHẤT CỦA MÕI TÀI KHOẢN THEO CHUDE Lập Trinh Mạng
SELECT TAIKHOAN.TEN,MAX(SCORE.SCORE) AS MAXDIEM  
FROM  SCORE 
JOIN CHUDE ON SCORE.CHUDE_ID=CHUDE.CHUDE_ID 
JOIN TAIKHOAN ON SCORE.TAIKHOAN_ID=TAIKHOAN.TAIKHOAN_ID 
WHERE CHUDE.TENCHUDE = N'Lập Trinh Mạng' 
GROUP BY TAIKHOAN.TEN 

-- CÁC tài khoản có điểm số cao nhất trong bộ đề Lập Trinh Mạng
WITH RankedScores AS (
    SELECT TAIKHOAN.TEN, SCORE.SCORE,
           DENSE_RANK() OVER (ORDER BY SCORE.SCORE DESC) AS Rank
    FROM SCORE
    JOIN CHUDE ON SCORE.CHUDE_ID = CHUDE.CHUDE_ID
    JOIN TAIKHOAN ON SCORE.TAIKHOAN_ID = TAIKHOAN.TAIKHOAN_ID
    WHERE CHUDE.TENCHUDE =  N'Lịch sử'
)
SELECT TEN
FROM RankedScores
WHERE Rank <= 1;

--Đếm số chủ đề trên hệ thống
SELECT  COUNT(CHUDE_ID) AS COUNTCD FROM CHUDE ;

--Đếm số bộ đề trên hệ thống
SELECT  COUNT(BODE_ID) AS COUNTBD FROM BODE ;


