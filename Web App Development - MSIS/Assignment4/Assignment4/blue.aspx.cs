using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Assignment4
{
    public partial class blue : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnGoToMainPage_Click(object sender, EventArgs e)
        {
            //Go back to the main page
            Response.Redirect("~/default.aspx");
        }
    }
}