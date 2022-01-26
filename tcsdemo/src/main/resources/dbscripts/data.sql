INSERT INTO Roles (Role_Name) VALUES 
('USER'),
('ADMIN');

INSERT INTO User (Name, User_Name, Password, Role_Id ) VALUES 
('Luis', 'luisp', 'password', 1),
('Juan','juanm', 'pass123', 2);

INSERT INTO Message (Message, MessageTo, MessageFrom) VALUES 
('Hello Luis', 1, 2);
