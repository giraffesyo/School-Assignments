<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="blue.aspx.cs" Inherits="Assignment4.blue" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/styles.css" rel="stylesheet" />
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <title>Blue Page</title>
</head>
<!-- Give body a class so we can use the same stylesheet for each page -->
<body class="bluepage">
    <form id="form1" runat="server">
        <div class="container">
            <div class="jumbotron">
                <h1>I am the Blue Page</h1>
            </div>
            <div class="row">
                <div class="col">
                    <asp:Button ID="btnGoToMainPage" runat="server" Text="Return to Main Page" OnClick="btnGoToMainPage_Click" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>
