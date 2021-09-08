INSERT INTO adresa (id, ulica, broj) VALUES (1,'Bulevar Cara Lazara', 5);
INSERT INTO adresa (id, ulica, broj) VALUES (2, 'Dalmatinska', 7);

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN',1);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK',2);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK',2);
              
INSERT INTO kompanija (id, naziv, adresa, telefon) VALUES (1, 'SM', 'SM SM 1', '013 111 111');
INSERT INTO kompanija (id, naziv, adresa, telefon) VALUES (2, 'SZ', 'SZ SZ 2', '021 211 111');
INSERT INTO kompanija (id, naziv, adresa, telefon) VALUES (3, 'MB', 'MB MB 3', '021 311 111');

INSERT INTO automobil (id, model, registracija, godiste, potrosnja, iznajmljen, kompanija_id) 
			VALUES (1, "Nissan Silvia", "VS 011 AC", 2003, "22", true, 1);
INSERT INTO automobil (id, model, registracija, godiste, potrosnja, iznajmljen, kompanija_id) 
			VALUES (2, "Mits mits", "NS 011 AC", 2020, "22", false, 2);
INSERT INTO automobil (id, model, registracija, godiste, potrosnja, iznajmljen, kompanija_id) 
			VALUES (3, "Nissan GTR R34", "NS 131 BO", 2016, "32", false, 2);
INSERT INTO automobil (id, model, registracija, godiste, potrosnja, iznajmljen, kompanija_id) 
			VALUES (4, "BMW E30", "VS 691 AE", 2006, "25", false, 1);
INSERT INTO automobil (id, model, registracija, godiste, potrosnja, iznajmljen, kompanija_id) 
			VALUES (5, "Mazda RX8", "VS 241 BA", 2007, "45", false, 2);

