import {Injectable} from '@angular/core';
import {stanze} from "../../shared/models/stanza";
import {Tag} from "../../shared/models/tags"
import {Projects} from "@angular/cli/lib/config/workspace-schema";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  roomSta: stanze[] = [];

  constructor() {
  }

  GetProject() {
    return this.roomSta;
  }

  GetProjectById(id: number): stanze {
    let project = this.roomSta.find(project => project.id === id);

    if (project === undefined) {
      throw new TypeError('Non ci sono stati risultati con questo id' + id);
    }
    return project;

  }

  GetRoomByFilter(filterTags: Tag[]) {
    let filterRoom: stanze[] = [];

    this.roomSta.forEach(function (room) {
      let foundAll = true;

      filterTags.forEach(function (filterTag) {
        if (room.tags.includes(filterTag) == false) {
          foundAll = false;
        }
      });
      if (foundAll) {
        filterRoom.push(room);
      }
    });
    return filterRoom;
  }

}
