'Get the Count of Items in Inbox
Set app = CreateObject("Outlook.Application")
Set nameSpace = app.GetNamespace("MAPI")
Set MyFolders = nameSpace.GetDefaultFolder(6)
'MsgBox MyFolders.Items.Count

'Read unread items in Inbox
Set cols = MyFolders.Items

For each mail In cols
If mail.unread Then
'WScript.Echo  mail.subject
'WScript.Echo  mail.sendername
'WScript.Echo  mail.body 
'WScript.Echo  mail.Attachments.Item(1).FileName


Dim value
value = WScript.Arguments(0)
path=WScript.Arguments(1)

if(mail.subject = value) Then

Dim fso : Set fso = CreateObject("Scripting.FileSystemObject")
Dim file : Set file = fso.OpenTextFile(path, 2, True)
file.Write mail.Attachments.Item(1).FileName
file.Close

End If

mail.unread=false
End If
Next
