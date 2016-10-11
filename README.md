# SoDA_Rush
Project for Club Rush 2016

## Downloading the Project
(**WARNING:** If you want to make changes to this project, ignore the instructions below. Follow the instructions under _Contributing Your Changes_ instead)

First, make sure you have Git installed. Open Git Bash or a Command Line with Git, and do the following:

1. Navigate to your Eclipse workspace (If you do not have one, create one, and note its location)
2. Type `git clone https://github.com/wvsoda/SoDA_Rush` to clone this repository. This should download everything

## Importing into Eclipse
1. Open Eclipse, and select the workspace where your project is located
2. Click File -> Import
3. Select General -> Existing Projects into Workspace
4. Check the Select root directory button, and click browse.
5. You should see the cloned project in the browse menu. DON'T CLICK ON IT. Just click ok
6. The project should appear under the Projects space. Select it (don't select anything else), and click finish

## Formatting
Project Specific Settings are enabled for this project. This is to help standardize formatting conventions accross all developers. Please do not modify the formatting settings (under .settings).
### Before you commit your changes
1. Right click on the project, and click on Source -> Format to format your entire project. We will not accept your changes if they don't follow our formatting conventions

## Contributing your changes
This project uses a Pull/Fork workflow, meaning most contributors **will not** have write access. If you want to make changes to this project rather than just browse around, then ignore the instructions under *Downloading the Project*, and follow the steps below.

1. Create a [fork](https://guides.github.com/activities/forking/) of this project
2. Clone your fork into your eclipse workspace, and import it into eclipse
3. Add the original repository as a remote called upstream so you can keep your fork up to date by running the following command: `git remote add upstream https://github.com/wvsoda/SoDA_Rush`
4. You may now make changes freely and commit as you wish. No need to create branches.

### Making changes
When you make changes that you wish to be merged with the original code, do the following:

1. Format your code in Eclipse (Check *Formatting* above). Commit your changes
2. Push your changes to your fork
3. Issue a [pull request](https://guides.github.com/activities/forking/). We will review your changes before merging them