SELECT * 
FROM Intents i 
LEFT JOIN Review r ON i.id = r.IdIntent
WHERE r.IdIntent IS NULL;


Select * from Review;
Select * from Intents;