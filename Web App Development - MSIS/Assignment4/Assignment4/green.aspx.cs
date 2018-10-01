using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Assignment4
{
    public partial class green : System.Web.UI.Page
    {
        private String referrer;
        protected void Page_Load(object sender, EventArgs e)
        {
            //If our referrer is null we will output N/A (in case they came directly to the green page)
            //Otherwise we will output the referrer (Main Page)
            referrer = Session["referrer"]?.ToString() ?? "N/A";
            lblReferrer.Text = referrer;
        }

        protected void btnReturnToMainPage_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/default.aspx");
        }
    }
}