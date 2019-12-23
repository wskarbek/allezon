ALTER TABLE auction ADD is_edited boolean;
UPDATE auction SET is_edited = FALSE;