ALTER TABLE Users
    ADD COLUMN password VARCHAR(32);

UPDATE Users SET password = '5f4dcc3b5aa765d61d8327deb882cf99' WHERE name = 'John' AND last_name = 'Doe' AND email = 'john.doe@example.com';
UPDATE Users SET password = '5f4dcc3b5aa765d61d8327deb882cf99' WHERE name = 'Alice' AND last_name = 'Smith' AND email = 'alice.smith@example.com';
UPDATE Users SET password = '5f4dcc3b5aa765d61d8327deb882cf99' WHERE name = 'Bob' AND last_name = 'Johnson' AND email = 'bob.johnson@example.com';