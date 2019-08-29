# Design Patterns Applied to Android App Codebase
In this project, Design Patterns have been applied to the existing android application Virtual Receptionist code to make the code better. Bad Smells have been recognized and removed from the code which we call, Refactoring.

**Improvements and Design Patterns which can be applied to Virtual Receptionist App Code?**

The improvements which can be made in current code of Virtual Receptionist are as follows:

1.	There are multiple classes which are duplicated due to type of login. The behavior application adopts after login for a visitor and employee can be set at runtime by using the “**Strategy Pattern**”. We can make a single login interface and decide on runtime whether use the employee behavior or employee behavior depending on the login ID and Password. I.e. if it is left blank, the user is a visitor. This will decrease the number of duplicated classes as well as reuse classes.

2.	The user of the application, whether employee or visitor needs to be notified about the appointments or meetings being changed, so we can use the “**Observer Pattern**” to improve this behavior.

3.	“**Singleton Pattern**” can also be used in the current code, as the employee object is quite expensive than visitor object, so it should be made only when needed and should be reused throughout the application runs. This will also help to provide a global point of access throughout the code.

4.	There a number of collections throughout the code. For example, pending meetings/appointments, confirmed meetings/appointments, passed meetings/appointments pending documents and reviewed documents. These collections have different data structures, for example, meetings/appointments are hash tables as they are filtered by the person who called the meeting or who made the appointment. This can be done by using “**Iterator Pattern**” as it would help to cater all the collections using a single interface.

5.	Our application uses remote objects to be accessed time to time and it also make a vast use of network through which employees and visitors are connected. In our application, one of our users is the Head of Organization. He is concealed as an employee to control his access. We can use “Remote Proxy Pattern” to cater this scenario in our application. We can also use “**Virtual Proxy Pattern**” in our application while the documents are loading, when an employee needs to access it.

6.	The “**Adapter Pattern**” can be used to adapt how a list of documents or meetings is showed. We can make an adapter which adapts the data from meetings or documents and make different data view in the same way.

7.	The “**Model-View-Controller**” pattern can also be applied to improve our application as it will collectively include most of the patterns or improvements discussed above. 

**Conclusion after applying Design Patterns and Code Refactoring**

The project “Virtual Receptionist” is an android application, due to which, it includes a lot of code which is just used to communicate between GUI and the core of the application. This code was also reused at many places in the project.

Before refractoring, it was hard to understand why a block of code was written. The programmer as well as a modifier would have been confused by looking at a bulk of code, just written to carry out tasks, without catering the fact that it would be read by someone. By applying Design Patterns to the project our code has become more managed and efficient. We have also found some of the Bad Smells and refactored it using the techniques available which makes our somehow perfect.

**More Information**

You can get more information and understanding of this project by reading **Proposal and Analysis Report.docx** and **Final Report.docx**
