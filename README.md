# Final_project_Java
עבודת פרויקט java  hit
שאלה 1 
שרת לקוח SQL עבור JAVA ומבנה נתונים לוקאלי עבור ANDROID
עליכם לבנות תוכנה לניהול וועד בית.
התוכנה תאפשר לוועד הבית לנהל מעקב אחרי ספקים, תשלומי דיירים, וכן אחרי ליקויים שיש לתקן בבניין המגורים. 
התוכנה תנוהל לפי שרת-לקוח TCP כך שבשרת יתממש בסיס הנתונים ( יתואר בהמשך ) ובצד הלקוח יתממש הלקוח ( שימו לב שיש מספר לקוחות )
הלקוחות:
1.	וועד הבית המנהל של התוכנה
2.	הדיירים 
מסך ראשון:
בתחילת התוכנה יוצג למשתמש תפריט בחירה: 
1.	וועד בית 
2.	דייר 
ברגע שנבחר על ידי המשתמש אחד מהשניים – תוצג למשתמש האפשרות הבאה:
1.	הקשת סיסמא והתחברות 
2.	בחירת סיסמא חדשה 
א. במידה והמשתמש החליט על האפשרות הקשת סיסמא והתחברות 
המשתמש יתבקש להקליד סיסמא ושם משתמש – הסיסמא ושם המשתמש יועברו לשרת שיבדוק את תקינות הקלט ( באמצעות בסיס נתונים SQL ) – במידה והקלט תקין יוחזר הודעת OK למשתמש והוא יוכל להתחיל לנהל שיחה מול השרת ובסיס הנתונים הנמצא בו 
ב. במידה והמשתמש בחר ללכת על בחירת סיסמא חדשה תוצג למשתמש הודעה להקליד את שם המשתמש בלבד וסיסמא חדשה שברצונו לקבוע – המידע יועבר לשרת ( כל האוביקט של המשתמש + הסיסמא החדשה ) שם הוא יעודכן בבסיס הנתונים של החברה, שימו לב על השרת לחפש את שם המשתמש בבסיס הנתונים ואז לעדכן את הסיסמא בו. 
מספר דגשים: 
בסיס הנתונים יכיל פרטים רבים על כל משתמש למשל: 
עבור וועד הבית : שם, שם משפחה, ת.ז. , מספר שנות וותק
עבור דייר: שם, שם משפחה, ת.ז. , מספר דירה, סכום חודשי לתשלום ( משתנה מדירה לדירה לפי גודלה – יתואר בהמשך ) 
ברגע שהמשתמש הקליד את שם המשתמש שלו ואת סיסמתו: 
א.	אם מדובר בוועד הבית תפתח מסך האופציות הבא: 
1.	הצג פרוט תשלומים של דייר : במידה ונבחרה אופציה זו המשתמש יצטרך להקליד את מספר הדירה המבוקש – הבקשה תעבור לשרת שיוחזר מחרוזת של כלל החודשים ששילם הדייר. ( לדוגמא : שולם 1 2 3 4 5 6 7 8 – ז"א עד אוגוסט כולל ).
2.	הצג פרוט של כלל התשלומים בבניין – יוצגו שורות כך שכל שורה תציג את מספר הדירה ולאחר מכן את התשלומים ששולמו ( לדוגמא: 1 1 2 3 4 ז"א דירה אחת שילמה עד אפריל. וכך הלאה עד הדייר האחרון ).
3.	עדכן תשלומים לדייר הוספה – במידה ודייר שילם וועד הבית יוכל להקליד את שם הדירה, חודש, ותשלום שבוצע בשקלים. 
הבקשה תועבר לשרת שיעדכן את בסיס הנתונים. 
4.	הצגת הכנסה חודשית לבניין לפי חודשים לדוגמא: 1 7900 2 8930 ... ז"א בינואר יכנס 7900 בפברואר 8930 וככה הלאה (ההכנסה לבניין נקבעת לפי תשלומי הדיירים – ז"א סכימה של כל הדיירים ששילמו או שהעבירו כסף לבניין לאותם חודשים ).
ב.	 אם מדובר בדייר:
1.	ינתן האופציה לדייר לראות את כל התשלומים שכבר שולמו על ידיו 
מספר הערות: 
1.	חובה לרשום הערות בקוד !! קוד ללא הערות לא יתקבל
2.	הציון בפרויקט יקבע לא רק לפי עובד או לא עובד אלא לפי יעילות ומחשבה – ז"א תבדק החשיבה מאחרי הפרויקט ולכן מומלץ עוד בטרם הליכה לקידוד לרשום על דף נייר ולתכנן את התוכנה
3.	המחלקות הקיימות יהיו: שרת , מזכירה, לקוח, וועד בית, דייר, בנאדם ( לצורך ההורשה ). 
4.	בסיס הנתונים יתואר לפי  בסיסי נתונים arraylist  או hashmap או hashset ו SQL , למשל אם רוצים להכניס דייר חדש לבניין ( ההגיון אומר לבדוק שהדייר לא קיים בבסיס נתונים – ואם לא קיים – להכניס אותו ) 
בהצלחה!
