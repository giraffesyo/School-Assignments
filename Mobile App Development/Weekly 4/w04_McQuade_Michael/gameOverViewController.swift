//
//  gameOverViewController.swift
//  w04_McQuade_Michael
//
//  Created by Michael McQuade on 9/14/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class gameOverViewController: UIViewController {

    //Create a var that will store our score from the previous screen
    var finalScore: Int = 0
    
    @IBOutlet var scoreLabel: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        scoreLabel.text = "Score: " + String(finalScore)
    }
    
    @IBAction func handleBackButton(_ sender: UIButton) {
        //Im sure there is a better way to do this but this is what I got,
        //Brings us back to the main menu and lets us start again
        self.presentingViewController?.presentingViewController?.dismiss(animated: false, completion: nil)
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
