<h3>Author: Bhargava Reddy Chinthareddy</h3>

<h4>Library: Selenium, TestNG</h4>

<h4>Language: Java - <b>JDK 21</b></h4>

<h4>Reporter: Extent reports</h4>

<h4>IDE: IntelliJ Idea</h4>

<h4>Framework: Page Object Model(Hybrid model)</h4>

<h4>Date of publish: January 9th 2024</h4>

<h4>Description:</h4>
<ol>
<li>The code is for learning, training and reference purpose only.</li>
<li>The code is for Google search automation testing purpose.</li>
</ol>

<h4>File structure:</h4>

<p>All the code files are in src folder. All the setup code for the tests are in under in java folder under 
main folder in src folder.</p>
<ul>
<li>Credentials:
<p>Contains all the hard coded values like search text, username, password, etc., can be or are stored.</p></li>
<li>Drivers:
<p>Contains code for driver set up and browser options</p></li>
<li>ObjectRepository:
<p>Contains all the elements code used in the file. The elements of each page should be stored separately.</p></li>
<li>Page Repository:
<p>Contains all the code used in the test. The code for each page should be created separately</p>
<p>Code in a single file can be used in different test files.</p>
</li>
<li>Extent reports:
<p>Contains all the Extent setup code used in the Project.</p>
<p>Step name and log line are given in the test file with the use of constructors</p>
</li>
<li>url:
<p>Contains hard coded values of all url's used in the test.</p></li>
</ul>
<p>All the code for to print log's in the console is placed under resources' folder.</p>
<p>All the test code is placed under test folder.</p>
<ul><li><b>Java:</b></li>
<p>Contains all the test steps. The test steps of each page are stored separately</p></ul>
<h5>Logs</h5>
<p>All the logs generated during the test are saved under test.log file under logs folder.</p>

<h4>Reporter</h4>
<p>Extent reporter is the reporter used in this project</p>
<p>The report will be generated like this</p>
<img src="img.png">