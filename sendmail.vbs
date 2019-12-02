Dim objOutl
'Dim myInspector As Outlook.Inspector
Set objOutl = CreateObject("Outlook.Application")
Set objMailItem = objOutl.CreateItem(olMailItem)

recipient = WScript.Arguments(0)
subject=WScript.Arguments(1)
body=WScript.Arguments(2)
attachmentpath=WScript.Arguments(3)



'comment the next line if you do not want to see the outlook window
objMailItem.Display
'strEmailAddr  = too

objMailItem.Recipients.Add recipient
objMailItem.Subject = subject
objMailItem.Body = body
objMailItem.Attachments.Add attachmentpath
objMailItem.Send
Set objMailItem = nothing
Set objOutl = nothing

'Application.Wait(Now + TimeValue("0:00:05"))

'Set myInspector=objMailItem.GetInspector
'myInspector.Activate
'SendKeys "%s" , True
