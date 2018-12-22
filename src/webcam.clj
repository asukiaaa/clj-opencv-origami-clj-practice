(ns webcam
  (:require [opencv4.core :as origami]
            [opencv4.video :as v]
            [opencv4.utils :as u]))

(defn -main [& args]
  (u/simple-cam-window
   (fn [buffer]
     (u/resize-by buffer 0.3)
     (let [output (origami/new-mat) bottom (-> buffer origami/clone (origami/flip! -1))]
       (-> buffer (origami/cvt-color! origami/COLOR_RGB2GRAY) (origami/cvt-color! origami/COLOR_GRAY2RGB))
       (origami/put-text buffer (str (java.util.Date.)) (origami/new-point 10 50) origami/FONT_HERSHEY_PLAIN 1 (origami/new-scalar 255 255 0) 1)
       (origami/vconcat [buffer bottom] output)
       output))))
