CREATE SCHEMA `A2VotingApp` ;

use A2VotingApp;

CREATE TABLE `a2votingapp`.`admins` (
  `idAdmin` INT NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdmin`),
  UNIQUE INDEX `idAdmin_UNIQUE` (`idAdmin` ASC)
);

CREATE TABLE `a2votingapp`.`students` (
  `idStudent` INT NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `voted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idStudent`),
  UNIQUE INDEX `idStudent_UNIQUE` (`idStudent` ASC) VISIBLE)
COMMENT = 'Holds Student Information';

CREATE TABLE `a2votingapp`.`candidates` (
  `idCandidate` INT NOT NULL,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `votes` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idCandidate`),
  CONSTRAINT `idStudents`
    FOREIGN KEY (`idCandidate`)
    REFERENCES `a2votingapp`.`students` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
insert into students (idStudent, fname, lname, email, password, voted) values (26779, 'Ozzy', 'Ludlem', 'oludlem0@etsy.com', 'xJun3y7', true);
insert into students (idStudent, fname, lname, email, password, voted) values (35324, 'Toni', 'Costa', 'tcosta1@weebly.com', 'tFU2Cz9hLOhQ', true);
insert into students (idStudent, fname, lname, email, password, voted) values (90285, 'Massimiliano', 'Caccavari', 'mcaccavari2@bluehost.com', 'uisgFjA4', true);
insert into students (idStudent, fname, lname, email, password, voted) values (30493, 'Faulkner', 'O''Neal', 'foneal3@simplemachines.org', '2KKkEri', false);
insert into students (idStudent, fname, lname, email, password, voted) values (70005, 'Massimo', 'Gamet', 'mgamet4@cnbc.com', 'eckFaQ90qG9', true);
insert into students (idStudent, fname, lname, email, password, voted) values (69032, 'Giacinta', 'Waghorne', 'gwaghorne5@harvard.edu', 'X35vpl3pZu', true);
insert into students (idStudent, fname, lname, email, password, voted) values (22656, 'Mikol', 'McMeanma', 'mmcmeanma6@facebook.com', 'rlBnicncE', false);
insert into students (idStudent, fname, lname, email, password, voted) values (85629, 'Nanete', 'Kleinsinger', 'nkleinsinger7@yelp.com', 'tawCKvBAdQoA', true);
insert into students (idStudent, fname, lname, email, password, voted) values (36008, 'Shelli', 'Revan', 'srevan8@ning.com', 'Ia0rew', false);
insert into students (idStudent, fname, lname, email, password, voted) values (34415, 'Rafaelita', 'Natte', 'rnatte9@linkedin.com', 'el1oxC', false);
insert into students (idStudent, fname, lname, email, password, voted) values (18579, 'Flori', 'Waind', 'fwainda@about.com', 'NIWbYj', false);
insert into students (idStudent, fname, lname, email, password, voted) values (24500, 'Bernadene', 'Touhig', 'btouhigb@dedecms.com', 'Rw20cEXJLE', true);
insert into students (idStudent, fname, lname, email, password, voted) values (47962, 'Martino', 'Auchterlonie', 'mauchterloniec@bigcartel.com', 'JskZJEn9D', false);
insert into students (idStudent, fname, lname, email, password, voted) values (52458, 'Harriett', 'Kingsford', 'hkingsfordd@imgur.com', '648Dj7ZItN', false);
insert into students (idStudent, fname, lname, email, password, voted) values (77240, 'Benedicto', 'Bromwich', 'bbromwiche@trellian.com', 'DYOXvoRyDet', true);
insert into students (idStudent, fname, lname, email, password, voted) values (67602, 'Donetta', 'Slemming', 'dslemmingf@linkedin.com', 'xNGsngbN', false);
insert into students (idStudent, fname, lname, email, password, voted) values (65957, 'Ichabod', 'Munns', 'imunnsg@github.com', '0q95rPb4x', false);
insert into students (idStudent, fname, lname, email, password, voted) values (66048, 'Pollyanna', 'Halbard', 'phalbardh@techcrunch.com', 'ystKzyI', false);
insert into students (idStudent, fname, lname, email, password, voted) values (81464, 'Averil', 'Neville', 'anevillei@parallels.com', '63U2dYX', false);
insert into students (idStudent, fname, lname, email, password, voted) values (92365, 'Augustus', 'Cooch', 'acoochj@comsenz.com', 'DTfUAENjj', false);
insert into students (idStudent, fname, lname, email, password, voted) values (42755, 'Deb', 'Loukes', 'dloukesk@homestead.com', 'qCydJ08M', false);
insert into students (idStudent, fname, lname, email, password, voted) values (44041, 'Leopold', 'Lancashire', 'llancashirel@independent.co.uk', 'xBTN1F6cMS', true);
insert into students (idStudent, fname, lname, email, password, voted) values (34916, 'Thomasa', 'Stapleton', 'tstapletonm@apache.org', 'drV9VuZQVvr', true);
insert into students (idStudent, fname, lname, email, password, voted) values (96845, 'Giff', 'Rohlfing', 'grohlfingn@gmpg.org', 'wR01MMNi93t', true);
insert into students (idStudent, fname, lname, email, password, voted) values (14113, 'Dorisa', 'Penner', 'dpennero@sohu.com', 'qJ17TdU0', true);
insert into students (idStudent, fname, lname, email, password, voted) values (34399, 'Philippine', 'Pryer', 'ppryerp@businessinsider.com', 'Fb6GABadPy7', false);
insert into students (idStudent, fname, lname, email, password, voted) values (88264, 'Cy', 'Purkins', 'cpurkinsq@blogspot.com', 'Ss1g8vLCPv', false);
insert into students (idStudent, fname, lname, email, password, voted) values (70892, 'Henderson', 'Welldrake', 'hwelldraker@utexas.edu', 'q1yWSQAGfi', false);
insert into students (idStudent, fname, lname, email, password, voted) values (38990, 'Gweneth', 'Turfitt', 'gturfitts@un.org', 'mwwNwauCo', true);
insert into students (idStudent, fname, lname, email, password, voted) values (92800, 'Marcellus', 'Lawman', 'mlawmant@cnbc.com', 'oS7BmxmYlv', true);
insert into students (idStudent, fname, lname, email, password, voted) values (31203, 'Dylan', 'Dumbreck', 'ddumbrecku@imgur.com', 'OX0ma5eh', true);
insert into students (idStudent, fname, lname, email, password, voted) values (56770, 'Clayton', 'Woodley', 'cwoodleyv@angelfire.com', 'Eg8QKnA', true);
insert into students (idStudent, fname, lname, email, password, voted) values (99313, 'Modesty', 'Gaitskell', 'mgaitskellw@yolasite.com', 'jnZ6YOVI', true);
insert into students (idStudent, fname, lname, email, password, voted) values (12659, 'Malia', 'Jambrozek', 'mjambrozekx@lulu.com', 'FOsCMPG5T', false);
insert into students (idStudent, fname, lname, email, password, voted) values (65582, 'Nefen', 'MacArdle', 'nmacardley@ow.ly', 'RhyKjiT', false);
insert into students (idStudent, fname, lname, email, password, voted) values (65017, 'Marielle', 'Rigby', 'mrigbyz@soundcloud.com', 'WdMzzDJQgYD', true);
insert into students (idStudent, fname, lname, email, password, voted) values (57335, 'Yasmin', 'Pestell', 'ypestell10@livejournal.com', 'VVBJBLn', false);
insert into students (idStudent, fname, lname, email, password, voted) values (35928, 'Benjamin', 'Greenrod', 'bgreenrod11@japanpost.jp', 'iqro24urFara', true);
insert into students (idStudent, fname, lname, email, password, voted) values (40520, 'Andie', 'Abriani', 'aabriani12@sbwire.com', 'ys1awtJ', false);
insert into students (idStudent, fname, lname, email, password, voted) values (25569, 'Killian', 'Flaherty', 'kflaherty13@cmu.edu', 'Q2QqA5tE1', true);
insert into students (idStudent, fname, lname, email, password, voted) values (48660, 'Briny', 'Serrell', 'bserrell14@bing.com', 'RpdIPsRf9D', true);
insert into students (idStudent, fname, lname, email, password, voted) values (22796, 'Trish', 'Milmore', 'tmilmore15@examiner.com', 'Ld0y3GY', false);
insert into students (idStudent, fname, lname, email, password, voted) values (29872, 'Justen', 'Filyashin', 'jfilyashin16@ovh.net', 'JqxkAopgd', true);
insert into students (idStudent, fname, lname, email, password, voted) values (78666, 'Donavon', 'Watkiss', 'dwatkiss17@lycos.com', '4OmtFnqKWjrE', false);
insert into students (idStudent, fname, lname, email, password, voted) values (91332, 'Mariam', 'Ashfull', 'mashfull18@dell.com', 'kkurvDt7', true);
insert into students (idStudent, fname, lname, email, password, voted) values (80936, 'Ranna', 'Lympenie', 'rlympenie19@last.fm', 'Azg6vIGom', false);
insert into students (idStudent, fname, lname, email, password, voted) values (62232, 'Ximenes', 'Conechie', 'xconechie1a@harvard.edu', 'PPJt2z3', true);
insert into students (idStudent, fname, lname, email, password, voted) values (36360, 'Christopher', 'Akhurst', 'cakhurst1b@ihg.com', 'OxkLbQxo', true);
insert into students (idStudent, fname, lname, email, password, voted) values (62616, 'Aurthur', 'Antoshin', 'aantoshin1c@netscape.com', 'F54VsfPMfZf', true);
insert into students (idStudent, fname, lname, email, password, voted) values (49321, 'Faith', 'Knightsbridge', 'fknightsbridge1d@instagram.com', '1SZafJVkE', false);
insert into students (idStudent, fname, lname, email, password, voted) values (22765, 'Kane', 'MacShirie', 'kmacshirie1e@businessweek.com', 'YJjOZ0', true);
insert into students (idStudent, fname, lname, email, password, voted) values (67504, 'Cyb', 'Stayt', 'cstayt1f@soundcloud.com', 'Xxkqs45VW6F', true);
insert into students (idStudent, fname, lname, email, password, voted) values (67727, 'Keane', 'Bourley', 'kbourley1g@addthis.com', 'HIfooc1r8nLj', true);
insert into students (idStudent, fname, lname, email, password, voted) values (71177, 'Allyce', 'Juste', 'ajuste1h@china.com.cn', 'xZ6fcIETJSIy', false);
insert into students (idStudent, fname, lname, email, password, voted) values (65781, 'Muffin', 'Hayhoe', 'mhayhoe1i@ted.com', '85VeyRFwf2lx', false);
insert into students (idStudent, fname, lname, email, password, voted) values (67752, 'Ariella', 'Yegorev', 'ayegorev1j@dion.ne.jp', '9VNdLcjelJdQ', false);
insert into students (idStudent, fname, lname, email, password, voted) values (31715, 'Beverlie', 'Plitz', 'bplitz1k@joomla.org', 'KSNnu5Sl', true);
insert into students (idStudent, fname, lname, email, password, voted) values (48294, 'Baxy', 'Braben', 'bbraben1l@arstechnica.com', 'TcEGZZhC', true);
insert into students (idStudent, fname, lname, email, password, voted) values (26213, 'Sarina', 'Dunstan', 'sdunstan1m@bbc.co.uk', 'TPvCa6MHg1n', true);
insert into students (idStudent, fname, lname, email, password, voted) values (53073, 'Siouxie', 'Tumasian', 'stumasian1n@si.edu', '4LGly3NkElK', true);
insert into students (idStudent, fname, lname, email, password, voted) values (97485, 'Dalila', 'Jencken', 'djencken1o@walmart.com', 'xmI7g1', true);
insert into students (idStudent, fname, lname, email, password, voted) values (77009, 'Bethina', 'Strother', 'bstrother1p@odnoklassniki.ru', 'spxdyY', false);
insert into students (idStudent, fname, lname, email, password, voted) values (53520, 'Denise', 'Graeme', 'dgraeme1q@thetimes.co.uk', 'PFToOWRWE', false);
insert into students (idStudent, fname, lname, email, password, voted) values (71703, 'Koressa', 'McCreagh', 'kmccreagh1r@wikimedia.org', 'RpDJfA', true);
insert into students (idStudent, fname, lname, email, password, voted) values (59694, 'Aryn', 'Barnard', 'abarnard1s@facebook.com', 'd6CWdxikyvL', true);
insert into students (idStudent, fname, lname, email, password, voted) values (81848, 'Filippo', 'Jencken', 'fjencken1t@globo.com', 'jdzYbgLXQwEk', false);
insert into students (idStudent, fname, lname, email, password, voted) values (25974, 'Ransell', 'Schonfelder', 'rschonfelder1u@pagesperso-orange.fr', 'pEWK20UU', true);
insert into students (idStudent, fname, lname, email, password, voted) values (42277, 'Sayre', 'Brimley', 'sbrimley1v@house.gov', 'nB92Miyd', true);
insert into students (idStudent, fname, lname, email, password, voted) values (45744, 'Carola', 'Iacobucci', 'ciacobucci1w@reuters.com', 'e1gaQ3dwV', true);
insert into students (idStudent, fname, lname, email, password, voted) values (99732, 'Devonna', 'Frisel', 'dfrisel1x@constantcontact.com', 'Kkzslj', true);
insert into students (idStudent, fname, lname, email, password, voted) values (46790, 'Constancy', 'Tattersill', 'ctattersill1y@list-manage.com', '0HnL5fYY7k', false);
insert into students (idStudent, fname, lname, email, password, voted) values (15165, 'Sonja', 'Solleme', 'ssolleme1z@woothemes.com', 'JQIWel', false);
insert into students (idStudent, fname, lname, email, password, voted) values (62679, 'Dave', 'Castellani', 'dcastellani20@narod.ru', 'BBalWQ', false);
insert into students (idStudent, fname, lname, email, password, voted) values (65694, 'Robbie', 'Rabley', 'rrabley21@sohu.com', 'IE5ajDZT2O', false);
insert into students (idStudent, fname, lname, email, password, voted) values (14497, 'Henry', 'Caghy', 'hcaghy22@t.co', 'kGoRgd3', true);
insert into students (idStudent, fname, lname, email, password, voted) values (75608, 'Andres', 'Klemke', 'aklemke23@posterous.com', 'yXUPquakF', false);
insert into students (idStudent, fname, lname, email, password, voted) values (74849, 'Frayda', 'Penniall', 'fpenniall24@eventbrite.com', 'UBrjK8P', true);
insert into students (idStudent, fname, lname, email, password, voted) values (39717, 'Talia', 'Gulk', 'tgulk25@illinois.edu', 'I60Wi7M', true);
insert into students (idStudent, fname, lname, email, password, voted) values (98578, 'Morgan', 'Morrid', 'mmorrid26@posterous.com', 'JU4ICsDPcJ', true);
insert into students (idStudent, fname, lname, email, password, voted) values (15560, 'Paolo', 'Toynbee', 'ptoynbee27@goodreads.com', '1zjnARR9', true);
insert into students (idStudent, fname, lname, email, password, voted) values (48545, 'Halsy', 'Ellams', 'hellams28@japanpost.jp', 'UItSsjZ4LA', true);
insert into students (idStudent, fname, lname, email, password, voted) values (78247, 'Shae', 'Halsall', 'shalsall29@sohu.com', 'Ljul0B3etBk', true);
insert into students (idStudent, fname, lname, email, password, voted) values (10267, 'Stormy', 'Crewe', 'screwe2a@cdbaby.com', 'o1QUu2bwPut', false);
insert into students (idStudent, fname, lname, email, password, voted) values (56721, 'Valerye', 'Bramhall', 'vbramhall2b@springer.com', 'O9779UO9', true);
insert into students (idStudent, fname, lname, email, password, voted) values (57299, 'Mufinella', 'McCarrell', 'mmccarrell2c@zimbio.com', 'cfT8I1t', true);
insert into students (idStudent, fname, lname, email, password, voted) values (16820, 'Clifford', 'Doore', 'cdoore2d@e-recht24.de', 'Jb03w7', true);
insert into students (idStudent, fname, lname, email, password, voted) values (27304, 'Kaitlynn', 'Frankcombe', 'kfrankcombe2e@google.co.uk', 'tqf4xAsOhLsW', false);
insert into students (idStudent, fname, lname, email, password, voted) values (61992, 'Milissent', 'Schuler', 'mschuler2f@nationalgeographic.com', 'Yx0j3JnUit', false);
insert into students (idStudent, fname, lname, email, password, voted) values (53069, 'Phebe', 'Magnay', 'pmagnay2g@cnbc.com', 'X0yvggd5', false);
insert into students (idStudent, fname, lname, email, password, voted) values (49135, 'Norbie', 'Whiteley', 'nwhiteley2h@lulu.com', 'FoRdDMwQck', false);
insert into students (idStudent, fname, lname, email, password, voted) values (17218, 'Katharine', 'De Witt', 'kdewitt2i@istockphoto.com', 'sYwwV5UUSsOR', false);
insert into students (idStudent, fname, lname, email, password, voted) values (83396, 'Malena', 'Beccero', 'mbeccero2j@soundcloud.com', 'kU5xgW7DdVn1', false);
insert into students (idStudent, fname, lname, email, password, voted) values (62333, 'Nichole', 'Cathee', 'ncathee2k@taobao.com', 'XI0bkZC4', true);
insert into students (idStudent, fname, lname, email, password, voted) values (49212, 'Roobbie', 'Sives', 'rsives2l@cbslocal.com', 'xy39Cr22T89y', true);
insert into students (idStudent, fname, lname, email, password, voted) values (33228, 'Maximilian', 'Gurko', 'mgurko2m@tamu.edu', 'PvkKuEk', false);
insert into students (idStudent, fname, lname, email, password, voted) values (83839, 'Magdalena', 'Creebo', 'mcreebo2n@g.co', 'bZl9Jq62d2b', false);
insert into students (idStudent, fname, lname, email, password, voted) values (23767, 'Ermanno', 'Geindre', 'egeindre2o@independent.co.uk', 'AKmhYQVJ', true);
insert into students (idStudent, fname, lname, email, password, voted) values (60643, 'Aurie', 'Ginn', 'aginn2p@bloglines.com', 'b4HmfmFOg', true);
insert into students (idStudent, fname, lname, email, password, voted) values (57151, 'Donaugh', 'Touson', 'dtouson2q@newsvine.com', 'dAfWDbAC67hb', false);
insert into students (idStudent, fname, lname, email, password, voted) values (61435, 'Dwayne', 'Ghilardini', 'dghilardini2r@un.org', 'PadfNc', false);

insert into candidates (idCandidate, fname, lname) values (61435, 'Dwayne', 'Ghilardini');
insert into candidates (idCandidate, fname, lname) values (78247, 'Shae', 'Halsall');
insert into candidates (idCandidate, fname, lname) values (39717, 'Talia', 'Gulk');
insert into candidates (idCandidate, fname, lname) values (25974, 'Ransell', 'Schonfelder');


insert into admins (idAdmin, fname, lname, email, password) values (1001, 'Daniel', 'Derich', 'daniel@votingadmin.ca', 'x!gW7&@');
insert into admins (idAdmin, fname, lname, email, password) values (1002, 'Ruby', 'Anne-Bautista', 'ruby@admin.ca', 'abc123');


