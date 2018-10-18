//
//  ViewController.swift
//  W08_McQuade_Michael
//
//  Created by Michael McQuade on 10/17/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet var deptAbbr: UITextField!
    @IBOutlet var courseNum: UITextField!
    @IBOutlet var courseTitle: UITextField!
    
    var deptAbbrResult = ""
    var courseNumResult: Int16 = 0
    var CourseTitleResult = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        deptAbbrResult = deptAbbr.text ?? "Bad DeptAbbr"
        courseNumResult = Int16(courseNum.text ?? "-1")!
        CourseTitleResult = courseTitle.text ?? "Bad Title"
    }


}

