USE ab_db;

TRUNCATE users;
INSERT INTO users (id, username, password, email, phone_number, date_of_birth, address_id)
VALUES (1, 'testuser', 'password', 'test@email.com', '210-123-4567', '12/31/1999', 1);

TRUNCATE activities;
INSERT INTO activities (id, name)
VALUES (1, 'hiking'),
(2, 'mountain biking'),
(3, 'cycling');

TRUNCATE addresses;
INSERT INTO addresses(id, address_one, address_two, city, state, zip_code, user_id)
VALUES (1, '123 Test Drive', '456 Trail Ave', 'San Antonio', 'TX', '78210', 1);
INSERT INTO addresses(id, city, state)
VALUES (2, 'Cross Mountain', 'Texas');

TRUNCATE emergency_contacts;
INSERT INTO emergency_contacts (email, first_name, last_name, phone_number, user_id)
VALUES('emergencycontact1@email.com', 'Jim', 'Adler', '444-444-4444', 1),
('emergencycontact2@email.com', 'Thomas J', 'Henry', '210-555-4444', 1);

TRUNCATE trails;
INSERT INTO trails (id, address_id, distance_inmi, lat, lng, name, ascent, descent, summary, type)
VALUES (7043446, 2, 6.5, 29.6409, -98.6258, 'Emilie and Albert Friedrich Wilderness Park Outer Loop', 678, -678, 'Enjoy a combination of trails at Friedrich Park that form a long and challenging 6.5-mile loop hike.', 'Loop' )

TRUNCATE reviews;
INSERT INTO reviews (id, comment, created_at, rating, image, trail_id, user_id)
VALUES (1, 'This was a challenging trail but it was very beautiful. Sparsely shaded areas, and quit the hike up some hills.', '08/23/20', 4, 'https://cdn2.apstatic.com/photos/hike/7041264_medium_1555103883.jpg',  7043446, 1)

TRUNCATE events;
INSERT INTO events (id, date, host_id, trail_id, description, title, activity_id)
VALUES (1, '2020-09-15', 1,  7043446, 'Going on a quick hike on the Outer Loop at Friedrich!', 'Outer Loop Hike', 1),
       (2, '2020-10-15', 1,  7043446, 'I plan on doing two laps of the loop this time. So make sure to bring plenty of water!', 'Outer Loop Trail x2' , 1);

INSERT INTO event_user (user_id, event_id)
VALUES (1, 1),
       (1, 2);