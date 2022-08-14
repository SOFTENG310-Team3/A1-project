How To Contribute

🐞Bugs
If you find a bug, create an issue with the label bug to document the bug report. Before doing do please make sure that
There is no current issue relating to said bug
 you are testing against the latest version

Bug descriptions should have:
Description of the bug
How the bug was found
Expected result of the test
Actual result of the test
New Features

If you see something that could be implemented, create a new feature request with an issue.  It should use the enhancement label, describe the new feature and why it is needed. The following steps should be followed when implementing a feature.

Check for dependencies and assign yourself to the issue
Fork and clone the repository
Create a new feature branch. Feature branches should have descriptive names. You should branch from master.
Make your changes in the feature branch in your local clone. If the change is large, consider using a feature flag and multiple pull requests.
Update your local repository with the most recent code from the main repository. Remember to rebase often – don’t wait until all changes have been made.
Test your changes – run all existing tests and any new tests you have created, run the code and make sure the application works as expected.
Create a pull request. The pull request should have a title which summarizes the changes. The body should provide more details about what changes have been made and should reference the number of the associated issue, e.g., "Fixed synchronization issue closes #123". The title of the pull request should not just reference the issue number – it should succinctly describe the actual changes.
Another team member must review and approve of the pull request. 
Once the reviewer approves the pull request, you (or a delegated team member) can merge your contribution into the main repository.
🛠️Pull Requests
A pull request is a way to suggest changes in our repository. All pull requests are reviewed by at least one team member before being approved and merged. Ensure that the code is bug free and all documentation is up to date before issuing a pull request.
External Services
To maximize code quality within the project, external services such as SonarCloud and SonarLint are being used. The use of these services is recommended to ensure the quality of the code maximized.

SonarLint can be downloaded from your chosen IDE’s marketplace and SonarCloud can be downloaded from https://sonarcloud.io.


Getting Started 

Fork and clone the main project repository 

Ways to contribute:

Contributing Code

Select an open issue to address, each contributor can only claim one issue at a time
Write your code on a new feature branch in your forked repo (branch from master)
Perform code analysis in Sonarlint in your IDE
Rebase your code to update your branch with the most recent code from the main repository
Test your code
Submit a pull request to merge your code to the master repository
If the issue had more than one contributor work on it, mention this in pull request comments
Choose a title that summarises the changes
Body should provide more detail about changes and reference associated issue number					
"Fixed synchronization issue closes #123" 
Your code will then be reviewed by another contributor 
Once approved, the changes can be merged to main 

Code Reviews

Open pull requests should undergo a code review by another contributor
Review should include
Running test suite
Running the code
Checking code against Sonarcloud
If bugs are identified during code review
These must be fixed by the original contributor 
Fixes must be approved by the reviewer
All commits should be squashed and merge conflicts resolved before merging 

	Create new issues

Create a new issue if you wish to:
Report bugs
Provide information for the bug to be reproduced 
Request a feature 
Describe the feature and why it is needed
Report documentation issues
Before creating:
Check that you are testing the latest version 
Check that there are no duplicate issues 
Issues must be approved by the team
Check that bug reports are reproducible 
Check feature requests are appropriate 
Check for duplicate issues
Dependencies to other issues should be included
If information about issue is missing:
Submitter should be asked for more details
To approve issues
Discuss at project coordination meetings
Require team to comment with their approval on the issue 
This process should be documented (in wiki?)



