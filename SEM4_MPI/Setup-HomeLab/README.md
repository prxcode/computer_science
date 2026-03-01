## How to setup this same TASM + DOSBox 16bit for Windows 11
- Download and install DOSBox, double click and Next to install, https://sourceforge.net/projects/dosbox/
- Create folder in C: -> `Dos`, so it be `C:/Dos`
- Add all files from requirements file into Dos folder <img width="880" height="883" alt="image" src="https://github.com/user-attachments/assets/9aa0e662-e654-409c-8553-0ae408bbb6d9" />

- Open `C:\Users\[YourName]\AppData\Local\DOSBox and open dosbox-0.74-3.conf`, scroll bottom and add this code snippet,
```bash
[autoexec]
# Lines in this section will be run at startup.
# You can put your MOUNT lines here.

mount c c:\dos
c:
echo TASM Environment Ready!

```
- Now open, DOSBox and start coding, with EDIT <filename>.asm, TASM <filename>.asm, TLINK <filename>.obj, TD <filename>.exe




## For Mac 
- Go to terminal type `brew install dosbox`
- Open dosbox, you would see `Z:>`
- now go to user dir, by opening Finder, type `CMD + SHIFT + H` and then create new folder here, `DOS` and inside it another folder `TASM`
- In this `TASM` folder put all these 13 files `https://github.com/prxcode/computer_science/tree/main/SEM4_MPI/Setup-HomeLab/DOS`
- Now Launch DOSBOX again and type `mount c ~/DOS`, then `c:`, now type `cd tasm`
- Done! now you would be able to run EDIT <filename>.asm, TASM <filename>.asm, TLINK <filename.obj>, TD <filename.exe>
