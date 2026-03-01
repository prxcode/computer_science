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
- Now Launch DOSBOX again and type `mount c ~/DOS`, then `c:`, now type `cd tasm`; you can also automate it by follwing below instructions
- Done! now you would be able to run EDIT <filename>.asm, TASM <filename>.asm, TLINK <filename.obj>, TD <filename.exe>





### Step 1 — Find DOSBox Config File (Mac)
Open Finder.
Press:
```
Command (⌘) + Shift + G
```

Paste:

```
~/Library/Preferences/
```

Press Enter.

Now look for a file like:

```
DOSBox 0.74-3-3 Preferences
```

(Version number may be slightly different.)

Open it with **TextEdit**.

---

### Step 2 — Scroll to the Bottom

Go to the very bottom.

You will see a section:

```
[autoexec]
# Lines in this section will be run at startup.
```

---

### Step 3 — Add These Lines Under [autoexec]

Add this:

```
mount c ~/DOS
c:
cd tasm
cls
```

So it looks like:

```
[autoexec]
mount c ~/DOS
c:
cd tasm
cls
```

Save the file.

Close it.

