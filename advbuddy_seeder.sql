USE ab_db;

TRUNCATE users;
INSERT INTO users (id, username, password, email, phone_number, date_of_birth, address_id)
VALUES (1, 'testuser', 'password', 'test@email.com', '210-123-4567', '1999-12-31', 1);

TRUNCATE activities;
INSERT INTO activities (id, name)
VALUES (1, 'hiking'),
(2, 'mountain biking'),
(3, 'cycling');

TRUNCATE addresses;
INSERT INTO addresses(id, address_one, address_two, city, state, zip_code, user_id)
VALUES (1, '123 Test Drive', '456 Trail Ave', 'San Antonio', 'TX', '78210', 1),
       (2, '123 Trail Drive', '456 Bugs Ave', 'San Antonio', 'TX', '78211', 1),
       (3, '123 Green Drive', '456 Tree Pl', 'San Antonio', 'TX', '78212', 1),
       (4, '123 Flower Trl', '456 Rainy Blvd', 'San Antonio', 'TX', '78213', 1),
       (5, '123 Blue Trl', '456 Happy Trl', 'San Antonio', 'TX', '78214', 1),
       (6, '123 Butterfly Rd', '456 Umbrella Rd', 'San Antonio', 'TX', '78215', 1),
       (7, '123 Mountain Ave', '456 Mount Tall Ave', 'San Antonio', 'TX', '78216', 1),
       (8, '123 Rocky Ridge Rd', '456 Bubble Tree Ave', 'San Antonio', 'TX', '78217', 1);

TRUNCATE emergency_contacts;
INSERT INTO emergency_contacts (email, first_name, last_name, phone_number, user_id)
VALUES('emergencycontact1@email.com', 'Jim', 'Adler', '444-444-4444', 1),
('emergencycontact2@email.com', 'Thomas J', 'Henry', '210-555-4444', 1);

TRUNCATE trails;
INSERT INTO trails (id, address_id, distance_in_mi, lat, lng, name, ascent, descent, summary, type)
VALUES (1, 2, 14.1, 29.6509, -98.6258, 'San Antonio Trail', 450, -450, 'A paved trail along the San Antonio River.', 'Trail'),
       (2, 3, 4.2, 29.6711, -98.6091, 'Texas Trail', 150, -110, 'A nice downhill trail that can get rocky at some points.', 'Trail'),
       (3, 4, 3.1, 29.6881, -98.6171, 'Mission Trail', 45, -10, 'A great trail that goes along all of the San Antonio Missions!.', 'Trail'),
       (4, 5, 5.6, 29.6972, -97.5091, 'Salado Creek Greenway', 123, -123, 'A paved trail great for cycling and walking/running with along the Salado Creek.', 'Trail'),
       (5, 6, 10.2, 29.6237, -97.9991, 'Leon Creek Trail', 100, -75, 'A trail with quite a few tall grasses. Plenty of birds to see!.', 'Trail'),
       (6, 7, 1.1, 29.6515, -97.8991, 'Big Boy Trail', -76, 220, 'Very steep, short trail that has a great view at the top.', 'Trail'),
       (7, 8, 7.7, 29.6321, -97.9891, 'Little Mountain Trail', 200, -20, 'Small hill that can be hiked in a loop.', 'Loop');

TRUNCATE reviews;
INSERT INTO reviews (id, comment, created_at, rating, image, trail_id, user_id)
VALUES (1, 'This was a challenging trail but it was very beautiful. Sparsely shaded areas, and quit the hike up some hills.', '08/23/20', 4, 'https://cdn2.apstatic.com/photos/hike/7041264_medium_1555103883.jpg',  7043446, 1)

TRUNCATE events;
INSERT INTO events (id, date, host_id, trail_id, description, title, activity_id)
VALUES (1, '2020-09-15', 1,  1, 'Going on a quick hike on the Outer Loop at Friedrich!', 'Outer Loop Hike', 1),
       (2, '2020-10-15', 1,  2, 'I plan on doing two laps of the loop this time. So make sure to bring plenty of water!', 'Outer Loop Trail x2' , 1);

INSERT INTO event_user (user_id, event_id)
VALUES (1, 1),
       (1, 2);