# A SCHOOL MINI ADMIN SYSTEM

This system was made with  Spring Framework,MySql and Java as the main/only Language.
This system Implements the Create,Read and Delete operations to enroll new students, view all registered students and remove a student data(In the case of expulsion) respectively, alongside with that it has secured endpoints with basic auth requiring the StaffID number and password 
which is hashed with Bcrypt by implementing Spring Security. 
It also implements Multipart file for integrated file uploads and binary data Stroage, Role Based access for Admins and also a search feature to find registered students by their Matriculation number using the "RequestParam" annotation.

