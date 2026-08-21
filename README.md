Automation of following scenarious:
Test scenario 1:
1.	Open https://cloud.google.com/
2.	Click “Ok, got it” cookie button.
3.	Click “Pricing” on the top menu.
4.	In the appeared menu click “Pricing calculator”
5.	Click "Add to estimate button".
6.	Click “Compute Engine” in the appeared pop up window.
7.	Fill out the form with the following data:
8.	* Service type: Instances
9.	* Number of instances: 4 
10.	* Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)
11.	* Provisioning Model: Regular
12.	* Select “General Purpose” in “Machine Family” section
13.	* Select “N1” in series section
14.	* Select “n1-standard-8” in “Machine type” section
15.	Select “Add GPUs”
16.	* GPU Model: NVIDIA Tesla P100
17.	* Number of GPUs: 1
18.	* Local SSD: 2x375 Gb
19.	* Region: Netherlands (europe-west4)
20.	* Committed use discount options: Resource-based CUD - 1 year 
21.	Click ‘Open detailed view’ in ‘ESTIMATED COST’ section
22.	The summary (detailed view) page will open in the separate tab.
23.	Switch to the newly opened tab (detailed view page).
24.	Check that the 'Total estimated cost' at “detailed view page” matches the result in the calculator.”

Test Scenario 2:
1.	Open https://cloud.google.com/
2.	Click “Ok, got it” cookie button.
3.	Click “Pricing” on the top menu.
4.	In the appeared menu click “Pricing calculator”
5.	Click "Add to estimate button".
6.	Click “Compute Engine” in the appeared pop up window.
7.	Fill out the form with the following data:
8.	* Service type: Instances
9.	* Number of instances: 4 
10.	* Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)
11.	* Provisioning Model: Regular
12.	* Select “General Purpose” in “Machine Family” section
13.	* Select “N1” in series section
14.	* Select “n1-standard-8” in “Machine type” section
15.	*Select “Add GPUs”
16.	* GPU Model: NVIDIA Tesla P100
17.	* Number of GPUs: 1
18.	* Local SSD: 2x375 Gb
19.	* Region: Netherlands (europe-west4)
20.	* Committed use discount options: Resource-based CUD - 1 year 
21.	Copy the sum of cost from “Total estimated cost” page 
22.	Open https://yopmail.com/en (YopMailSender page)
23.	Click “Random Email Generator” button
24.	Click “Check inbox” button
25.	Click “New message” button
26.	Paste the copied sum into e-mail content field
27.	Type the “Total estimated cost” into the “Subject” field
28.	Open https://yopmail.com/en once again into new tab (YopMailRecipient page)
29.	Click “Random Email Generator” button
30.	Click “New” button to generate new e-mail address different from the first one at “YopMailSender page”
31.	Copy the name of as-created email
32.	Turn back to previous “YopMailSender” page with created letter
33.	Click “New message” button to make previously inserted data be visible 
34.	Enter the copied email address into the recipient field
35.	Press “Send” button
36.	Verify the “Your message has been sent” informational icon appears at a   YopMailSender page.
