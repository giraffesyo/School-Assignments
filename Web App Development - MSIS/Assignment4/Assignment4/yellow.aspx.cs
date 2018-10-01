using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Assignment4
{
    public partial class yellow : System.Web.UI.Page
    {
        //Declare a message variable
        private String message;
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void btnReturnToMainPage_Click(object sender, EventArgs e)
        {
            //Set message variable to our text box's value
            message = tbMessageToMainPage.Text;
            //Set the YellowMessage Session variable equal to our message
            Session["YellowMessage"] = message;
            //Go back to the main page
            Response.Redirect("~/default.aspx");
        }
    }
}