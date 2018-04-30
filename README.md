# Conference Organizer

## Conference Organizer Overview 

Conference Organizer application organizes the received proposals into one or more tracks for the
conference. Each track has a morning and afternoon session. Each session has multiple talks. All talk
lengths are either in minutes or lightning (5 min). Morning session begins at 9:00 AM and finishes by
12:00 PM for lunch. Afternoon session begins at 1:00 PM and finishes in time for networking event. The
networking event can start no earlier than 4:00 PM and no later than 5:00 PM. There are no gaps
between the sessions.

## Prerequisite

The application is written in Java 1.8. No third-party libraries are used in the application. The following
software installation is required to run the application  
- JDK 1.8
- Maven 3.x

## Usage

1. Download the application.  

2. Run “mvn clean install” in the terminal window or run as maven install in IDE.  

3. It will execute all the unit tests and create a runnable jar file called “conference-organizer-0.0.1-SNAPSHOT.jar” in “target” folder inside project.  

4. Application can run through either IDE or terminal window.  

5. Provide all input proposals in a text file called “input.txt” in the current working directory.  

6. Run “java -jar conference-organizer-0.0.1-SNAPSHOT.jar” from terminal window or run as java application from IDE.  

7. After successful execution, it will print a message in the console: -  
    Application execution started  
    Application execution ended  
    Check "output.txt and "log.txt" files.  

8. On success, it will create two files “output.txt” and “log.txt” in current working directory.  

9. On failure, “output.txt” will not be created but “log.txt” will be created with error details.  

## Samples

### Input

Writing Fast Tests Against Enterprise Rails 60min  
Overdoing it in Python 45min  
Lua for the Masses 30min  
Ruby Errors from Mismatched Gem Versions 45min  
Common Ruby Errors 45min  
Rails for Python Developers lightning  
Communicating Over Distance 60min  
Accounting-Driven Development 45min  
Woah 30min  
Sit Down and Write 30min  
Pair Programming vs Noise 45min  
Rails Magic 60min  
Ruby on Rails: Why We Should Move On 60min  
Clojure Ate Scala (on my project) 45min  
Programming in the Boondocks of Seattle 30min  
Ruby vs. Clojure for Back-End Development 30min  
Ruby on Rails Legacy App Maintenance 60min  
A World Without HackerNews 30min  
User Interface CSS in Rails Apps 30min  

### Output

#### Track 1:
09:00AM Writing Fast Tests Against Enterprise Rails 60min  
10:00AM Overdoing it in Python 45min  
10:45AM Lua for the Masses 30min  
11:15AM Ruby Errors from Mismatched Gem Versions 45min  
12:00PM Lunch 60min  
01:00PM Sit Down and Write 30min  
01:30PM Pair Programming vs Noise 45min  
02:15PM Rails Magic 60min  
03:15PM Ruby on Rails: Why We Should Move On 60min  
04:15PM Clojure Ate Scala (on my project) 45min  
05:00PM Networking Event  
#### Track 2:
09:00AM Woah 30min  
09:30AM Programming in the Boondocks of Seattle 30min  
10:00AM Ruby vs. Clojure for Back-End Development 30min  
10:30AM Ruby on Rails Legacy App Maintenance 60min  
11:30AM A World Without HackerNews 30min  
12:00PM Lunch 60min  
01:00PM Common Ruby Errors 45min  
01:45PM Rails for Python Developers lightning  
01:50PM Communicating Over Distance 60min  
02:50PM Accounting-Driven Development 45min  
03:35PM User Interface CSS in Rails Apps 30min  
04:05PM Networking Event  

### Log

DEBUG: RequestProcessor: process start  
INFO: Validation Time :16 millis  
DEBUG: RequestProcessor: input validation succeed  
DEBUG: OrganizerImpl: organize start  
DEBUG: SessionFinderImpl: findFirstSession start  
DEBUG: SessionFinderImpl: findFirstSession end  
DEBUG: SessionFinderImpl: findSecondSession start  
DEBUG: SessionFinderImpl: findSecondSession end  
DEBUG: OrganizerImpl: Track 1 added  
DEBUG: SessionFinderImpl: findFirstSession start  
DEBUG: SessionFinderImpl: findFirstSession end  
DEBUG: SessionFinderImpl: findSecondSession start  
DEBUG: SessionFinderImpl: findSecondSession end  
DEBUG: OrganizerImpl: Track 2 added  
DEBUG: OrganizerImpl: organize end  
INFO: Organize Time :31 millis  
INFO: Process Time :125 millis  
DEBUG: RequestProcessor: process end  
