INSERT INTO infoentity VALUES (NULL,'jens@hotmail.dk');
INSERT INTO infoentity VALUES (NULL,'mette@gmail.com');
INSERT INTO infoentity VALUES (NULL,'gertrud@ofir.dk');
INSERT INTO infoentity VALUES (NULL,'emil@arto.dk');

INSERT INTO address VALUES (NULL,(select ID from infoentity where EMAIL='jens@hotmail.dk'),'Fuglevej 54','',(select ZIPCODE from cityinfo where ZIPCODE='2820'));
INSERT INTO address VALUES (NULL,(select ID from infoentity where EMAIL='mette@gmail.com'),'Bjørnevej 69','',(select ZIPCODE from cityinfo where ZIPCODE='2412'));
INSERT INTO address VALUES (NULL,(select ID from infoentity where EMAIL='gertrud@ofir.dk'),'Eksisterer Ikke Vej 420','',(select ZIPCODE from cityinfo where ZIPCODE='6541'));
INSERT INTO address VALUES (NULL,(select ID from infoentity where EMAIL='emil@arto.dk'),'Bag Ved En 7/11 I Herning','',(select ZIPCODE from cityinfo where ZIPCODE='7400'));

INSERT INTO phone VALUES (NULL,(select ID from infoentity where EMAIL='jens@hotmail.dk'),'49283753','Kan rigtig godt lide torskerogn');
INSERT INTO phone VALUES (NULL,(select ID from infoentity where EMAIL='mette@gmail.com'),'33826532','Arbejder i IKEA');
INSERT INTO phone VALUES (NULL,(select ID from infoentity where EMAIL='gertrud@ofir.dk'),'55467946','Spiller squash i sin fritid');
INSERT INTO phone VALUES (NULL,(select ID from infoentity where EMAIL='emil@arto.dk'),'43424343','Går i bukser lavet af hamp');

INSERT INTO company VALUES (NULL,(select ID from infoentity where EMAIL='jens@hotmail.dk'),'Footlocker','Kan rigtig godt lide fødder','65458795',420,'500,000');
INSERT INTO company VALUES (NULL,(select ID from infoentity where EMAIL='mette@gmail.com'),'JustEat','Gir os masser af mad','55487955',69,'420,000');
INSERT INTO company VALUES (NULL,(select ID from infoentity where EMAIL='gertrud@ofir.dk'),'Big Boss Dog Publishing','De er lidt underlige','45789663',187,'69,000');
INSERT INTO company VALUES (NULL,(select ID from infoentity where EMAIL='emil@arto.dk'),'Please Help Me I Am Dying LLC','Avoid at all costs','36636343',1,'-500,000,000');

INSERT INTO person VALUES (NULL,(select ID from infoentity where EMAIL='jens@hotmail.dk'),'Jens','Mortensen');
INSERT INTO person VALUES (NULL,(select ID from infoentity where EMAIL='mette@gmail.com'),'Mette','Mouritsen');
INSERT INTO person VALUES (NULL,(select ID from infoentity where EMAIL='gertrud@ofir.dk'),'Gertrud','Bodilsen');
INSERT INTO person VALUES (NULL,(select ID from infoentity where EMAIL='emil@arto.dk'),'Emil','Hjælpmigsen');

INSERT INTO hobby VALUES (NULL,(select ID from infoentity where EMAIL='jens@hotmail.dk'),'Crocket','Pænt baller');
INSERT INTO hobby VALUES (NULL,(select ID from infoentity where EMAIL='mette@gmail.com'),'Fletning','Ikke specielt baller');
INSERT INTO hobby VALUES (NULL,(select ID from infoentity where EMAIL='gertrud@ofir.dk'),'Squash','Gør pisse ondt');
INSERT INTO hobby VALUES (NULL,(select ID from infoentity where EMAIL='emil@arto.dk'),'At blive knust af kapitalismen','Whoops');