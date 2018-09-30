//
//  LapTimesViewController.swift
//  MW1_McQuade_Michael
//
//  Created by Michael E McQuade on 9/29/18.
//  Copyright © 2018 giraffesyo.io. All rights reserved.
//

import UIKit

class LapTimesViewController: UIViewController {

    var stopwatch: Stopwatch = Stopwatch()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print (stopwatch.getLapCount())
        // Do any additional setup after loading the view.
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
