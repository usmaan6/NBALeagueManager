USE leaguemanager;

-- team data
INSERT INTO `team` VALUES
(1,'celtics','Massachusetts',32,9,183480482.0000),
(2,'bulls','illinois',20,23,166945505.0000),
(3,'lakers','california',21,21,166559330.0000),
(4,'mavericks','texas',24,18,161832304.0000),
(5,'clippers','california',26,14,154368528.0000),
(6,'spurs','texas',7,33,137086683.0000),
(7,'heat','florida',24,17,180047223.0000),
(8,'timberwolves','Minnesota',30,11,162931412.0000),
(9,'hornets','North Carolina',8,30,135400834.0000);
-- end team data

-- player data
INSERT INTO `player` VALUES
(1, 'LeBron', 'James', 22.3, 8,4.3,123456789.0000,2),
(2, 'Kevin', 'Durant', 28.3, 6,5.1,378900245.0000,2),
(3, 'Derrick', 'Rose', 15.2, 2,6.3,7483294.0000,2),
(4, 'Ja', 'Morant', 27.3, 4,7.8,20480222.0000,2),
(5, 'Kyrie', 'Irving', 30.1, 5,6.3,4782944234.0000,2);

-- end player data

-- coach data
INSERT INTO coach VALUES
(1,'John','Madden', 70000, 70, 50, 1),
(2,'Bill','Billecheque',70000, 10, 50, 2),
(3,'Joe','Johnson',100000, 40, 50, 3),
(4,'Pat','Riley',90000, 30, 50, 4),
(5,'Gregg','Poppovich',80000, 60, 50, 5);
-- end coach data