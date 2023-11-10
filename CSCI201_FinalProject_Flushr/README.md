# Flushr

The purpose of Flushr is to make it easy for people to find bathrooms near them. The features in Flushr will allow users to find bathrooms based on proximity, different rankings (rating, wait time, etc.), and as well as leave ratings on these bathrooms for others to see. For the purpose of this application, we will only be implementing public bathrooms on USC’s campus (including the USC Village).

Flushr will include a map showing the locations of bathrooms in the user’s area. Users will be able to search for bathrooms, with options to sort the results by proximity, cleanliness, availability, and accessibility. Users will be able to view the information for each bathroom (provided through user ratings). Logged in users will be able to leave ratings on the bathroom’s cleanliness, availability, and accessibility.


## How does Flushr work?

Flushr is connected to an internal database holding all (most) known public bathrooms on USC Campus. It utilizes a Google Maps API to locate nearby restrooms based on the user's location, and also a Google Sign-In API to allow users to sign in to save and rate their bathrooms of choice.

Front-end is mainly done via HTML/CSS and Javascript (JS); backend is completed with Java and SQL for database.

It also makes use of AWS:
- S3: to store bathroom data in a bucket to be pulled
- Elastic Beanstalk: to deploy and host the server
- Route 53: to get the domain name


## Who uses Flushr?

Flushr first gained inspiration from the IBS (irritable bowel syndrome) community, our intended end users. IBS is a common, chronic GI (gastrointestinal) disorder affecting the digestive system — this often means they need to be prepared to find a bathroom near them at all times. Flushr makes that easy.

Although the IBS community is our intended audience, this can be used universally by USC students. Whether you're in a hurry or unfamiliar with the campus, Flushr can sure be handy in the right time.


