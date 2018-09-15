//
//  gameViewController.swift
//  w04_McQuade_Michael
//
//  Created by Michael McQuade on 9/14/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class gameViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    @IBAction func handleGoBack(_ sender: UIButton) {
        //handle resetting the game here perhaps
        dismiss(animated: false, completion: nil )
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
