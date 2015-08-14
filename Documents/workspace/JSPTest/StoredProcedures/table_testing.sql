CALL sp_insert_post('Book','Offer','39.99','Introduction to Algorithm',null);
SELECT * FROM mydb.posts;


CALL sp_get_last_post_id();