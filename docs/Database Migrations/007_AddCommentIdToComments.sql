ALTER TABLE comments ADD parentId INTEGER;
ALTER TABLE comments ADD CONSTRAINT fk_comments_parent FOREIGN KEY (parentId) REFERENCES comments(commentId);
INSERT INTO migrations (dbVersion) VALUES (7);