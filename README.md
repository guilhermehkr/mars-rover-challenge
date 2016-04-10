# challenge

## This program should be run using unit test classes.

Firstly, go to test resources folder and paste there file should be tested.
Secondly, go to SpecsSetup object and insert your file name into yourFileName constant.

After these steps, run command 'activator test' through terminal inside the project folder
You don' need to have SBT to run, there is a activator version in the project.

I decided by:

- While file is reading, some validation are done and if there is something wrong in the rover entry, this rover will be marked as invalid and won't
be processed
- When it is found at least one wrong command ( something not like Left, Right and Movement ), this rover will be marked as invalid
- When rovers goes out of plateau, it will be marked as invalid

Ps.: This program does not take care of rovers in the same spot AND file must always have a couple of lines for one rover,
otherwise it'll be a messy, unfortunately!
