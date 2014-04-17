Dim RegEx, WSH, myList,app,item
Set RegEx = New RegExp
Set WSH = CreateObject("WScript.Shell")
Set oExec = WSH.Exec("C:\IBM\WebSphere\AppServer\profiles\BPM801\bin\wsadmin.bat -username wasadmin -password wasadmin -lang jython -c AdminApp.list()")

RegEx.Pattern ="'.*'"

Do Until oExec.Status = 0
	WScript.Sleep 100
Loop

Do Until oExec.StdOut.AtEndOfStream
	Line = oExec.StdOut.ReadLine
	result=line
	If RegEx.Test(Line) Then myList = replace(RegEx.Replace(Line, result),"'","")
Loop

resultArray = split(myList,"\r\n")

for each item in resultArray
	app= item & vbCR
	WScript.Echo app
next
